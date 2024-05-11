# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /usr/local/google/buildbot/src/android/build-tools/current/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.

# Keeping entry points for activities, services, and similar
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends androidx.core.app.AppComponentFactory

# Keep names of classes used in XML layouts
-keepclassmembers class ** {
    @android.view.View$*;
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
    public void set*(...);
}

# Keep enum values, might be used in switch statements
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# Preserve all native method names and the names of their classes
-keepclasseswithmembernames class * {
    native <methods>;
}

# Avoid obfuscating synthetic classes, which are important for Kotlin
-keep class kotlin.Metadata { *; }

# Keep data binding related classes
-keep class * implements androidx.databinding.DataBindingComponent {
    <methods>;
}
-keep class * implements androidx.databinding.ViewDataBinding {
    <methods>;
}

# Keep names of fields annotated with @BindView
-keepclassmembers class * {
    @butterknife.BindView <fields>;
}

# Keep Parcelable implementations
-keepclassmembers class * implements android.os.Parcelable {
    static ** CREATOR;
}
