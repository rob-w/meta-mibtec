#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>

#define DONTCARE    0
#define BEGINLOOP     1
#define ENDLOOP     1

int RunShellScript(char * filename, char cExecAll)
{
  char pszLine[256]="\0";
  char *pszNewLine=NULL;
  char bEOF=0;
  char cErrorFlag=0;
  FILE * pfileptr=NULL;

  int nLine =1;
  int nret=0;
  int nPhase=DONTCARE;

  long int nlFilePos=0;

  //open file
  pfileptr=fopen(filename,"r");
  if(!pfileptr)
#ifdef DEBUG
    {printf("cannot open file %s\n",filename); return -1;}
#else
    return -1;
#endif



  while(!bEOF && !feof(pfileptr))
    {
      fgets(pszLine,sizeof(pszLine),pfileptr);
      //eat newline
      pszNewLine=strchr(pszLine,'\n');
      pszNewLine[0]='\0';

      //lets scan the keywords
      if(!strncmp(pszLine,"#EOF",sizeof(pszLine)))
	bEOF=1;
      else if(!strncmp(pszLine,"#BEGINLOOP",sizeof(pszLine)))
	{nPhase=BEGINLOOP; nlFilePos=ftell(pfileptr);}
      else if(!strncmp(pszLine,"#ENDLOOP",sizeof(pszLine)))
	{nPhase=ENDLOOP; fseek(pfileptr,nlFilePos,SEEK_SET);}
      else if(pszLine[0]!='#')
	{
#ifdef DEBUG
	  printf("%s\n",pszLine);
	  nret =0;
#else
	  printf("executing Line %d %s \n",nLine, pszLine);
	  nret = system(pszLine);
#endif
	}
      else
	nret=0; //comment

      //error?
      if(nret && !cExecAll)
	{
	    return nLine;
	}
      else if (nret && cExecAll)
	cErrorFlag = 1;

      nLine++;
    }
  if(cErrorFlag)
    return -4;
  else
    return(0);
}

int main(int argc, char* argv[], char* envp[])
{
    char pszDefaultSourceFile[]="/usr/local/bin/start.scr";
    char pszDefaultStickSourceFile[]="/mnt/mstick/start.scr";
    char pszSourceFile[256]="\0";
    struct stat buf;
    int nret =0;

    //check arguments
    if(argc==2)
	strncpy(pszSourceFile,argv[1],sizeof(pszSourceFile)-1);
    else
      {
	if(!stat(pszDefaultStickSourceFile,&buf))
	  strncpy(pszSourceFile,pszDefaultStickSourceFile,sizeof(pszSourceFile)-1);
	else
	  strncpy(pszSourceFile,pszDefaultSourceFile,sizeof(pszSourceFile)-1);
      }

    nret = RunShellScript(pszSourceFile, 1 /*do not exit if error*/);

    if(nret)
      printf("error #%d",nret);

    return nret;
}
