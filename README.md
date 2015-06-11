# android-recyclerview

Learn the Android RecyclerView

# Section 1: Create RecyclerView

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
    - Update the height attribute of `TextView`: `android:layout_height="wrap_content"`
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


## Create `Car.java` as a simple data model

git commit message: create data model

**Step-by-step**

- Create a new Java class named `Car`.
    - Create 2 private members (both String) named `make` and `model`.
    - Create a simple constructor that requires both members to be set.
    - Define a getter and setter for both private members.


## Create the `CarAdapter`

git commit message: create the adapter

**Step-by-step**

- Create a new Java class named `CarAdapter`. [Source](https://github.com/exponential-io/android-recyclerview/blob/master/app/src/main/java/io/exponential/androidrecyclerview/CarAdapter.java)


## Set the `RecyclerView` adapter and layout manager

git commit message: create RecyclerView instance in MainFragment

**Step-by-step**

- Update `MainFragment`: [Source](https://github.com/exponential-io/android-recyclerview/commit/542887267a18fd9d6dc894b3f952b3824fc626c8)


At this point you can run your application. You will see a list of cars displayed in the
`RecyclerView`. Up next, we'll add the ability to handle `RecyclerView` touch events.


# Section 2: Add event handlers to RecyclerView

## Create an event handler for `RecyclerView` in `MainFragment`

git commit message: create event handler for RecyclerView

**Step-by-step**

- Update the `onCreateView` method in `MainFragment` as follows:
    - Create a new variable to hold the context: `Context context = getActivity();`.
    - Replace `getActivity()` with `context` everywhere in the method.
    - Create a new `GestureDetector` so that we can override the `onSingleTapUp` method. We need to
      override this method to inform Android that we have handled the single tap event via:
      `final GestureDetector gestureDetector = new GestureDetector`. [Source](https://github.com/exponential-io/android-recyclerview/commit/8db614aa185516add0c7cf4b1104fbe8a3de3864)
    - Bind the listeners to the `RecyclerView` via `carsRecyclerView.addOnItemTouchListener`.
- Update `fragment_main.xml`:
    - Add the `android:clickable="true"` attribute to the `android.support.v7.widget.RecyclerView`
      element.

## Pass event up to Activity

git commit message: pass RecyclerView event up to Activity

**Step-by-step**

- Update the `onCreateView` method in `MainFragment` as follows:
    - In `onInterceptTouchEvent`, delete the `Toast`.
    - In `onInterceptTouchEvent`, invoke `callbacks.setHomePage(message);`

That's it. To start another Activity you would simply create an Intent and call `startActivity`
in the implementation of `setHomePage` in `MainActivity`.
