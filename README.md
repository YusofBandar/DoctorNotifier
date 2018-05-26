# DoctorNotifier
Doctor Notifier is a system that allows patients signal to their doctors/nurses. The system allows doctors to subscribe and unsubscribe to patients by scanning RDIF sensor with an appropriate tag. Doctors can subscribe to unlimited number of patients, if patient signals for help all subscribed doctors will be notified, once a doctor unsubscribes from a patient he/she will no longer receive any messages. 

[Phidget Sensors](https://www.phidgets.com/?) both a Dial and RDIF Sensor were used. The dial was used to choose help message, depending on the dials position, a different message will be broadcast to any subscribers. The RDIF Sensor allowed a efficient way to subscribe and unsubscribe to a patient.

[The MQTT Protocol](http://mqtt.org/) was used as the protocol to broadcast message. Each patient acted as the Broker (Server), allowing the broadcast of messages and each doctor acted as subscriber. The MQTT Protocol was chosen because it allowed low power method to receive a large number of messages

## Demo
### One Doctor
***Doctor_1*** RFID Scan ***Patient_1*** Tag ===> ***Doctor_1*** Subscribed to ***Patient_1***

***Patient_1*** Needs Help ===> ***Patient_1*** Dial Turned to Positon 2 ===> Message Broadcast to Subscribed Doctors

***Doctor_1*** receives message ===> Problem Addressed

***Doctor_1*** RFID Scan ***Patient_1*** Tag ===> ***Doctor_1*** Unsubscribes to ***Patient_1***

---

### Multiple Doctors
***Doctor_1*** and ***Doctor_2*** RFID Scan ***Patient_2*** Tag  ⟹ ***Doctor_1*** and ***Doctor_2*** Subscribed to ***Patient_2***

***Patient_1*** and ***Patient_2*** Needs Helps ===> ***Patient_1*** and ***Patient_2*** Dials Turned to Position 4 ===> Message Broadcast to Subscribed Doctors

***Doctor_1*** and ***Doctor_2*** receives message from ***Patient_2*** ===> Problem Addressed by both Doctors

***Patient_1*** Problem Not Addressed ===> No Doctors Were Subscribed

***Doctor_1*** RFID Scan ***Patient_2*** Tag ===> ***Doctor_1*** Unsubscribes to ***Patient_2***

***Doctor_1*** RFID Scan ***Patient_1*** Tag ===> ***Doctor_1*** Subscribed to ***Patient_1***


# Setup

## Prerequisites

### Libraries
[**Phidget 22**](https://www.phidgets.com/docs/Language_-_Java#Libraries) needed for the sensors

[**Eclipse Paho (MQTT 3.1.1)**](https://www.eclipse.org/paho/clients/java/#) needed for MQTT communication

### Equipment

#### Sensors
* [**Phidget Dial**](https://www.phidgets.com/?prodid=44)
* [**Phidget RFID**](https://www.phidgets.com/?prodid=23)
* [**PhidgetInterfaceKit 8/8/8**](https://www.phidgets.com/?tier=3&catid=2&pcid=1&prodid=1021)

#### Additional Equipment
* [**LED**](https://www.phidgets.com/?tier=3&catid=60&pcid=53&prodid=442)
* [**RFID Tags**](https://www.phidgets.com/?tier=1&catid=47&pcid=40)

## Installation

## Sensors
Attach the Phidget dial to PhidgetInterfaceKit 8/8/8 Voltage Input Channel 3
Attach the LED to Digital Outputs Channel 0 and GRND

Plug the PhidgetInterfaceKit 8/8/8 and the Phidget RFID to the computer

## Application
Install the [**Phidget 22**](https://www.phidgets.com/docs/Language_-_Java#Libraries) and [**Eclipse Paho (MQTT 3.1.1)**](https://www.eclipse.org/paho/clients/java/#) libraries

Run the program 


## Authors
* **Yusof Bandar** - [YusofBandar](https://github.com/YusofBandar)
* **Abd-Assamad Achouri** - [Achouri12](https://github.com/Abd-AssamadAchouri)
* **Naim Ahmed** - [NaimAhmed](https://github.com/NaimAhmed)
* **Pritam Sangani** - [PritamSangani](https://github.com/PritamSangani) 

See also the list of [contributors](https://github.com/YusofBandar/DoctorNotifier/graphs/contributors) who participated in this project.
