# NeuBrutalism
[![](https://jitpack.io/v/raghavtilak/NeuBrutalism.svg)](https://jitpack.io/#raghavtilak/NeuBrutalism)
<br>A library to help you utilise the Simplicity & Aesthetics of Brutalism UI Design in Android. 

# Demo #

|Buttons|Dialog|
|--|--|
|![neubrutalismbuttons](https://user-images.githubusercontent.com/74963954/215754716-c19e3d63-9b23-4a9b-abd6-bc2aea000710.gif)|![neubrutalismdialog](https://user-images.githubusercontent.com/74963954/215791603-96cefdca-2a65-4983-9798-d9336a800aaf.gif)|

# Usage 🛠️ #
## Dependency #
> Step 1. Add the JitPack repository to your build file
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

>Step 2. Add the dependency
```
	dependencies {
	        implementation 'com.github.raghavtilak:NeuBrutalism:1.0.1'
	}
```
## Layout File #
```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">

    <com.raghav.neubrutalism.NeuBrutalismView
        android:id="@+id/neubrutview"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        
        <!--   **Customisable Attributes**    -->
        app:bg_marginStart="6dp"
        app:bg_marginTop="6dp"
        app:bg_radius="3dp"
        app:fg_color="@color/white"
        app:fg_strokeColor="@color/black"
        app:fg_strokeWidth="4dp"
        app:bg_shadowColor="@color/black">

        <TextView
            android:id="@+id/textview"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:gravity="center"
            android:padding="30dp"
            android:text="Hello"
            android:textAlignment="center"
            android:textSize="20sp" />
    </com.raghav.neubrutalism.NeuBrutalismView>

</androidx.constraintlayout.widget.ConstraintLayout>

```
## Dynamic Properties #
```
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val neubutton = findViewById<NeuBrutalismView>(R.id.neubrutview)
        neubutton.setOnClickListener {
            Log.d("TAG","Onclick")
        }
        neubutton.bg_shadowColor = Color.BLUE
    }
}

```
