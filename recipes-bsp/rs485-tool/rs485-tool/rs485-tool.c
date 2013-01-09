#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#include <linux/serial.h>


/* Driver-specific ioctls: */
#define TIOCGRS485      0x542E
#define TIOCSRS485      0x542F
#define O_WR 2

void
usage(void) {
	
	printf("rs485-tool:\n");
	printf("\t -f PATH_TO_SERIAL_DEVICE\n");
	printf("\t -e [0/1] Enable or Disabel RS485 mode\n");
	printf("\t -h show this help\n");
	exit(-1);
}

struct serial_rs485 rs485old, rs485new;
int main(int argc, char **argv)
{
int siOpt;
extern char *optarg;
char path[1023];
int i;
int mode = -1;
int fd ;

 sprintf(path, "/dev/null");
 
 while ((siOpt = getopt (argc, argv, "f:e:h")) != -1) {
	switch (siOpt) {
		case 'e':
			mode = atoi(optarg);
		break;
		case 'f':
			snprintf(path,1024, optarg);
			printf("Device %s\n", path);
		break;
		case 'h':
			usage();
		break;
		}
	}

	if (mode == 0 || mode == 1)
		printf("Going to switch RS485 %s\n", mode ? "ON" : "OFF");
	else 
		usage();
	
	if (strstr(path, "/dev/null"))
		usage();
	
	fd = open (path, O_WR);
	if (fd < 0) {
		printf("fd open Error to open %s\n", path);
		usage();
	}

	memset(&rs485new, sizeof(rs485new), 0);

	/// get current flags 
	if (ioctl (fd, TIOCGRS485, &rs485old) < 0) 
		printf("ioctrl Error on TIOCGRS485 \n");

	/// copy to new struct
	rs485new.flags = rs485old.flags;

	/// Set general rs485 Mode and RTS Sendable usage
	if (mode == 1) {
		rs485new.flags |= SER_RS485_ENABLED;
		rs485new.flags |= SER_RS485_RTS_ON_SEND;
		}
	else
		rs485new.flags = 0;
		
	/// write out to device
	if (ioctl (fd, TIOCSRS485, &rs485new) < 0) 
		printf("ioctrl Error on TIOCSRS485 \n");

	/// read back to compare
	if (ioctl (fd, TIOCGRS485, &rs485old) < 0) 
		printf("ioctrl Error on TIOCGRS485\n");

	/// compare flags
	if (rs485new.flags != rs485old.flags) {
		printf("Error comparing flags");
		exit(-1);
	}
	else
		printf("RS485 Flags look good\n");
	
	exit(0);
}
