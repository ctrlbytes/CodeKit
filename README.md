# CodeKit

[![](https://jitpack.io/v/ctrlbytes/CodeKit.svg)](https://jitpack.io/#ctrlbytes/CodeKit)
[![API](https://img.shields.io/badge/API-19%2B-orange.svg?style=flat)](https://android-arsenal.com/api?level=19)

## Adding to your project

1. Add the JitPack repository to your build.gradle at the end of repositories:

```groovy
repositories {
  ...
  maven { url 'https://jitpack.io' }
}
```

2. Add the dependency

```groovy
implementation 'com.github.ctrlbytes:CodeKit:0.1.2'
```

## Usage

### ScreenFlow

```java
ScreenFlow.from(fragment|activity|context).to(AnotherActivity.class);
```
### ConnectivityUtils

```java

ConnectivityUtils.isInternetOn(context);
ConnectivityUtils.isMobileDataOn(context);
ConnectivityUtils.isWiFiOn(context);

```

### YLog

```java

//Init in start of the Application
YLog("YOUR_APP_TAG", enabled|disable);

//Use wherever you want
YLog("SCREEN_TAG", "LOG_MESSAGE");

```
