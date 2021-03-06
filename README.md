# CodeKit

[![](https://jitpack.io/v/ctrlbytes/CodeKit.svg)](https://jitpack.io/#ctrlbytes/CodeKit)
[![API](https://img.shields.io/badge/API-19%2B-orange.svg?style=flat)](https://android-arsenal.com/api?level=19)
![Android CI](https://github.com/ctrlbytes/CodeKit/actions/workflows/android.yml/badge.svg)

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
implementation 'com.github.ctrlbytes:CodeKit:LATEST_VERSION_HERE'
```

## Usage

### ConnectivityUtils
```kotlin

ConnectivityUtils.isInternetOn(context);
ConnectivityUtils.isMobileDataOn(context);
ConnectivityUtils.isWiFiOn(context);

```

### AppsInDevice
```kotlin
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

### TextInputLayout KTX
```kotlin
getValue()
setValue(string)
clear()
```

### View KTX
```kotlin
hide() // visibility gone by default
hide(VISIBLE|GONE) // or specify
show() // visibility visible
```

### Date KTX
```kotlin
format("dd-MM-yyy")
format("dd-MM-yyy", locale)
format(simpleDateFormat)
```

### Cursor KTX
```kotlin
val items = dbCursor.toList {
   it.getString(0)
}
```

### Utils KTX
```kotlin
runSafe {
    // do things that may throw error and don't care about the error (error will be printed to the console)
}
```