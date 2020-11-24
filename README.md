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
implementation 'com.github.ctrlbytes:CodeKit:0.1.3'
```

## Usage

### ConnectivityUtils

```java

ConnectivityUtils.isInternetOn(context);
ConnectivityUtils.isMobileDataOn(context);
ConnectivityUtils.isWiFiOn(context);

```

### AppsInDevice

```java
AppsInDevice.isInstalled(context, packageName)
```

### Context KTX

```kotlin
launchActivity(activityClass) { intent ->
    putExtra()
}

openUrl(urlString)

toast(stringRes|string)
toast(stringRes|string, LENGTH_SHORT)

openAppInPlayStore() // will open current app
openAppInPlayStore(appPackageName) // will open the specified package
```
### Fragment KTX

```kotlin
toast(stringRes|string)
toast(stringRes|string, LENGTH_SHORT)
```

### TextInputLayout
```kotlin
getValue()
setValue(string)
clear()
```

### View
```kotlin
hide() // visibility gone by default
hide(VISIBLE|GONE) // or specify
show() // visibility visible
```