# android-recyclerview

Learn the Android RecyclerView

## Create project

git commit message: initial commit; project created

**Step-by-step**

- Create new project with a blank Activity.

## Create a new Fragment

git commit message: create new Fragment

**Step-by-step**

- Create a new blank Fragment named `MainFragment`.

## Update the Fragment

git commit message: setup Fragment

**Step-by-step**

- Update `strings.xml`:
    - Add a new string resource `<string name="fragment_main_title">Main Fragment</string>`
- Update `fragment_main.xml`:
    - Change `FrameLayout` to `RelativeLayout`.
    - Update the `TextView` with an attribute of `android:text="@string/fragment_main_title"`.
- Update `MainFragment`:
    - Change `import android.app.Fragment;` to `import android.support.v4.app.Fragment;`.
    - Delete `ARG_PARAM1` and `ARG_PARAM2`.
    - Delete `mParam1` and `mParam1`.
    - Rename `OnFragmentInteractionListener` to `Callbacks`.
    - Rename `mListener` to `callbacks`.
    - Delete `mParam1` and `mParam1` from the `newInstance` parameters list.
    - Delete all code related to the Bundle in `newInstance`.
    - Delete the arguments code from the body of `onCreate`.
    - In `onCreateView`, split save the inflated view in a variable of type `View` and return it.
    - Delete the `onButtonPressed` method.
    - Update the `Callbacks` interface as follows:
        - Delete the `onFragmentInteraction` method.
        - Create a new method signature: `public void setHomePage(String name);`
- Update `activity_main.xml`:
    - Delete the default `TextView.
    - Insert a `FrameLayout` with an id of `container` that `MainFragment` can be inserted into.
- Update `MainActivity`:
    - Change the extends from `ActionBarActivity` to `AppCompatActivity`:
    - Insert the `MainFragment` into the `MainActivity` layout in the `container`.
    - Override the `setHomePage` method from the `MainFragment.Callbacks` interface.
    - Display a `Toast` in the `setHomePage` body via
      `Toast.makeText(MainActivity.this, "Clicked: " + name, Toast.LENGTH_SHORT).show();'

## Add the `recyclerview` dependency to `build.gradle`

git commit message: add recyclerview dependency to build.gradle

**Step-by-step**

- Add the following to the `dependencies` section of `app/build.gradle`:
    - `compile 'com.android.support:recyclerview-v7:21.0.+'`


## Add `RecyclerView` to `fragment_main.xml`

git commit message: add RecyclerView to fragment's layout

**Step-by-step**

- Update `fragment_main.xml` as follows:
    - Add an id to the `TextView`: android:id="@+id/fragment_title"
    - Add the following `RecyclerView` below the `TextView:

```xml
<android.support.v7.widget.RecyclerView
        android:id="@+id/cars"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:scrollbars="vertical"
        android:layout_below="@id/fragment_title"/>
```

## Create a layout for the `RecyclerView` row

git commit message: add item layout

**Step-by-step**

- Create a new file named `res/layout/car.xml`. [Source](https://github.com/exponential-io/android-recyclerview/blob/master/app/src/main/res/layout/car.xml)


## XXXX

git commit message: YYY

**Step-by-step**

-

## XXXX

git commit message: YYY

**Step-by-step**

-