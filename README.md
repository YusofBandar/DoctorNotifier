# DoctorNotifier
Doctor Notifier is a system that allows patients signal to their doctors/nurses. The system allows doctors to subscribe and unsubscribe to paitents by scanning RDIF sensor with a approiate tag. Doctors can subsribe to unlimited number of patients, if patient signals for help all subscribed doctors will be notified, once a doctor unsibsribes from a paitent he/she will no longer recive any messages. 


[Phidiget Sensors](https://www.phidgets.com/) both a Dial and RDIF Sensor were used. The dial was used to choose help message, depending on the dials position, a different message will be broadcast to any subscribers. The RDIF Sensor allowed a efficeint way to subsribe and unscribe to a patient.

[The MQTT Protocal](http://mqtt.org/) was used as the protocal to broadcast message. Each patient acted as the Broker (Server), allowing the broacast of messages and each doctor acted as subscriber. The MQTT Protocal was chosen because it allowed low power method to recive a large number of messages

## Demo

***Doctor_1*** RFID Scan ***Patient_1*** Tag ===> ***Doctor_1*** Subscribed to ***Patient_1***

***Patient_1*** Needs Help ===> ***Patient_1*** Dial Turned to Positon 2 ===> Message Broadcast to Subscribed Doctors

***Doctor_1*** recieves message ===> Problem Solved

***Doctor_1*** RFID Scan ***Patient_1*** Tag ===> ***Doctor_1*** Unsubsribes to ***Patient_1***

# Setup

## Prerequisites

### Libraries
[**Phidiget 22**](https://www.phidgets.com/docs/Language_-_Java#Libraries) needed for the sensors

[**Eclipse Paho (MQTT 3.1.1)**](https://www.eclipse.org/paho/clients/java/#) needed for MQTT communication

### Equipment

#### Sensors
* [**Phidiget Dial**]()
* [**Phidiget RFID**]()
* [**PhidgetInterfaceKit 8/8/8**]()

#### Additional Equitment
* [**LED**]()

## Installation

## Sensors
Attach the Phidiget dial to PhidgetInterfaceKit 8/8/8 Voltage Input Channel 3
Attach the LED to Digital Outputs Channel 0 and GRND

Plug the PhidgetInterfaceKit 8/8/8 and the Phidiget RFID to the computer

## Application
Install the [**Phidiget 22**](https://www.phidgets.com/docs/Language_-_Java#Libraries) and [**Eclipse Paho (MQTT 3.1.1)**](https://www.eclipse.org/paho/clients/java/#) libraries

Run the program 


## Authors
* **Yusof Bandar** - [YusofBandar](https://github.com/YusofBandar)
* **Abd-Assamad Achouri** - [Achouri12](https://github.com/Abd-AssamadAchouri)
* **Naim Ahmed** - [NaimAhmed](https://github.com/NaimAhmed)
* **Pritam Sangani** - [PritamSangani](https://github.com/PritamSangani) 

See also the list of [contributors](https://github.com/YusofBandar/DoctorNotifier/graphs/contributors) who participated in this project.
