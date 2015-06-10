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

## XXXX

git commit message: YYY

**Step-by-step**

-

## XXXX

git commit message: YYY

**Step-by-step**

-

## XXXX

git commit message: YYY

**Step-by-step**

-

## XXXX

git commit message: YYY

**Step-by-step**

-

## XXXX

git commit message: YYY

**Step-by-step**

-