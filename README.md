# Astrology DB Android Studio

### The Problem
Love or hate Astrology, the reality is that reading Native charts require a heavy handed amount of Googling <br />
Furthermore, you CANNOT google for example: Moon in Pisces in the 11th House. <br />
Instead you must google: <br>
	- Moon In Pisces <br />
	- Moon In 11th House <br />
	- Pisces in 11th House <br /> <br>
This is not optimal or helpful for the aspiring or curious astrologer
### The Solution
* Get detailed astrological data quick with a maximum of 3 taps on a phone screen.
* Be the first application to combine Planetary, Zodiac and House attributes

### UI Design
* Designed as minimal as possible
* All Native chart signs are the icons on the UI, 
reinforcing beginner knowledge and preparing them to handle Native charts
* All are using TableLayout which can be provide even distribution using 
wrap_content and match_parent android:xml functionality

### Calling the API
AS = Android Studio
* REST functionality is handled by *???* to access the endpoints of my other GitHub project
 backend counterpart Astrology-API.
 * Accessing endpoints via Localhost requires an additional URL query = 10.0.2.2
 * All instance fields which are updated inside the JSONParse method must be inside oncreate();
 as AS cannot instantiate objects before the layout of an activity has been instantiated first.
 * This method will be adapted for use for all planets, signs and houses, 
 but for now, this is the raw functioning method.

 ```java
    private void jsonParse(TextView tv) {
        AndroidNetworking.get("http://10.0.2.2:8080/astrals/planet/Sun")
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObject(AstralBody.class, new ParsedRequestListener<AstralBody>() {
                    @Override
                    public void onResponse(AstralBody astralBody) {
                        System.out.println("Working!");
                        tv.setText(astralBody.toString());
                    }
                    @Override
                    public void onError(ANError anError) {
                        System.out.println("Error" + anError.getMessage());
                    }
                });
    }
}
 ```
 
 ### RoadMap of Features in Order of Release:
 
 1. Return all Astral Body Data. 
 2. Return all Sign Data.
 3. Return all house Data.
 4. Build Aspect UI and Functionality.
 5. Provide Astral, Zodiac and House data attributes through Aspects.
 
 ### Screenshots
 ### Home Page Activity
 ![AstroAppHome](https://user-images.githubusercontent.com/63508057/106888526-94ca7080-66de-11eb-8627-3e367c5c3ebf.png)

### Planets Activity
![AStroAppPlanets](https://user-images.githubusercontent.com/63508057/106888258-343b3380-66de-11eb-98d9-d0438f569606.png)

### Single Planet Data
![AstroAppSun](https://user-images.githubusercontent.com/63508057/106888259-343b3380-66de-11eb-8508-33c1a459e0cf.png)

### Signs Activity
![AstroAppSigns](https://user-images.githubusercontent.com/63508057/107042710-f6134200-67b9-11eb-83ef-ce691148744d.png)

### Single Sign Data
![AstroAppAries](https://user-images.githubusercontent.com/63508057/107042714-f7446f00-67b9-11eb-8dd8-902ca4927a3b.png)

### All House Data
![AstroAppHouse](https://user-images.githubusercontent.com/63508057/107042718-f8759c00-67b9-11eb-9706-f940e9c29284.png)
 
