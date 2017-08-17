WagLabs Coding Challenge

Third Party Libraries Used
- Picasso:  This library is used to load images into views.  It is very efficient and caches the images after they are loaded the first time to allow for seamless image viewing.  It also allows for placeholders while the image is loading, including animations.
- GSON: This library allows easy conversion of JSON data into usable Objects without the need to JSON manipulation.
- Android Support Libraries including recyclerview and appcompat.

The App
- The project is contained within the WagLabsTest directory of this repository.
- The app fulfiles the requirements of pulling the user's Gravitar, Username, and Badge Counts, as well as their reputation.  It presents this information in a recyclerview with loading animations.
- The list items are a recreation of the way you would see a user on the site under answered questions
- When started there is a loading bar shown until the app recieves the response, where a recyclerview will be populated with the written adapter.  A callback is done on the MainActivity and is provided to the task to allow this.
- Images will initially have a loading circle animated until the image download is complete, at which point when the view is recycled and re-loaded the image will appear instantly.
