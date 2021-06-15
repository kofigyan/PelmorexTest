PelmorexTest App
===========================================================

This app allows users to view selected weather conditions albeit on limited basis. Additionally it simulates comment form submission and image viewing.


Introduction
-------------

### Functionality
The app is composed of 4 main screens.
#### MainActivity
Allows the user to select among the three solutions

#### WeatherInfoActivity
Weather information for  selected cities.

#### CommentActivity
Simulate comment form submission with specific validations.

#### PhotoActivity
Photo gallery


### Building
You can open the project in Android studio and press run.
### Testing
Still in development. 
The project will uses both instrumentation tests that run on the device
and local unit tests that run on your computer. 

#### Device Tests
##### UI Tests
The projects will use Espresso for UI testing.  

#### Local Unit Tests 


### Libraries
* [Android Extension Libraries][extension-lib]
* [Android Architecture Components][arch]
* [Retrofit][retrofit] for REST api communication
* [Glide][glide] for image loading
* [espresso][espresso] for UI tests
* [mockito][mockito] for mocking in tests
 

[extension-lib]: https://developer.android.com/jetpack/androidx
[arch]: https://developer.android.com/topic/libraries/architecture
[espresso]: https://google.github.io/android-testing-support-library/docs/espresso/
[retrofit]: http://square.github.io/retrofit
[glide]: https://github.com/bumptech/glide
[mockito]: http://site.mockito.org 
