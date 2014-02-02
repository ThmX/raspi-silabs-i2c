Raspberry Pi & Silabs C8051F340 (I2C)
=====================================

This tutorial shows how to communicate between a **Raspberry Pi** and a **Silicon Laboratories C8051F340** board by **I2C**.

### Libraries

* Pi4J 0.0.5

The installation of the Pi4J library is explained on [their website](http://pi4j.com/install.html).

### Boards connection

The following table describes the connection between the two boards:

![Raspberry Pi & Silabs C8051F340](https://github.com/ThmX/raspi-silabs-i2c/raw/master/raspi-silabs-i2c.png "Raspberry Pi & Silabs C8051F340")

| Pin name  | Silabs F340 | RPi GPIO P1 Header | Pi4J #    |
| --------- |:-----------:|:------------------:|:---------:|
|  GND      | GND         | P1.6               |  - (0v)   |
|  SDA      | P0.0 (SDA)  | P1.3               |  8 (SDA0) |
|  SCL      | P0.1 (SCL)  | P1.5               |  9 (SCL0) |

> Careful though, the `Vcc` should be at 3.3V as we are using the **Raspberry Pi** as master.
We have to make sure the circuit that will be connected with is also powered on 3.3V. Otherwise, we will have to create an interface circuit. Check the [RPi GPIO Interface Circuits](http://elinux.org/RPi_GPIO_Interface_Circuits#Level_Shifters) for more info.

### Silabs F340

We are going to use the Silabs Application Notes [SMBus Communication for Small Form Factor Device Families](http://www.silabs.com/Support%20Documents/TechnicalDocs/an141.pdf). When running, the F340 will send back the data that has been received.

Use the [Silicon Labs IDE](http://www.silabs.com/products/mcu/Pages/8-bit-microcontroller-software.aspx#ide) to open the `SMBusTest.wsp` project file inside the [F340 directory](https://github.com/ThmX/raspi-silabs-i2c/tree/master/f340/) to compile and run this example.

### Raspberry Pi (with Pi4J)

Use the sbt project inside the [raspi directory](https://github.com/ThmX/raspi-silabs-i2c/tree/master/raspi/) to compile and run this example.

	$ sbt test

This will launch the `I2CTest` test which should connect to the I2C, write data on the bus and read back the data from the **F340**.

## References

* [Raspberry Pi](www.raspberrypi.org)
* [The Pi4J Project](http://pi4j.com/)
* [Silicon Labs](http://www.silabs.com/pages/default.aspx)
	* [C8051F340 Datasheet](http://www.silabs.com/Support%20Documents/TechnicalDocs/c8051f34x.pdf)
	* [C8051F34x Development Kit User's Guide](http://www.silabs.com/Support%20Documents/TechnicalDocs/c8051f34x-dk.pdf)
	* [8-bit Microcontroller Studio](http://www.silabs.com/products/mcu/Pages/8-bit-microcontroller-software.aspx)

## License

The MIT License (MIT)

Copyright (c) 2014 Thomas Denoréaz

Permission is hereby granted, free of charge, to any person obtaining a copy of
this software and associated documentation files (the "Software"), to deal in
the Software without restriction, including without limitation the rights to
use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
the Software, and to permit persons to whom the Software is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.