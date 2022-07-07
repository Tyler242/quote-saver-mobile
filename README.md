# Overview

Quote Saver is a mobile app I built to familiarize myself with Mobile App Development using Android Studio and Kotlin. I learned the basics of Android Studio and plan to continue increasing my understanding of the mobile app development process.

The purpose of Quote Saver is to store quotes that are meaningful to you or you find enjoyable. It has built in functionalities that allow you to search for different quotes by word, source, and keywords that you have attached to the quotes. This allows the user to find quotes or sayings for specific situations with just a little effort.

[Quote App Demo](https://youtu.be/CEf7HeUk2HE)

# Development Environment

I used Android Studio and the Kotlin programming language to build this app.

# Useful Websites

* [Android for Developers](https://developer.android.com/)
* [Kotlin Documentation](https://kotlinlang.org/docs/home.html)
* [Tutorial for Bottom Navigation](https://www.youtube.com/watch?v=v8MbOjBCu0o&ab_channel=CodeWithMazn)
* [Code Labs for Android](https://codelabs.developers.google.com/?cat=Android)

# Recent Updates

* June 10th 2022 - Updated the word search to sort the quotes by frequency. Quotes with more instances of the word will appear at the top and will continue in a descending order.
* June 12th 2022 - Added an individual quote view that displays the quote, source, date added, and keywords. This view has buttons for editing and deleting the quote as well. This view can be accessed from the list view by selecting the text of the quote.
* June 27th 2022 - Updated the styling of all buttons to be a light blue circle with an icon instead of a purple rectangle with text.
* July 5th 2022 - Changed the quote storage type from txt to json to simplify CRUD operations and to prepare for api integration. You should not see any notable difference in the UI.
* July 6th 2022 - Fixed a bug that causes a crash when there are no quotes and the user navigates to the dashboard.

# Future Work

* Fix the created date variable for the quotes.
* Add a carousel on the dashboard that scrolls through recently added, edited, highest viewed.
* Change from local storage to using an API and cloud database combination that returns JSON objects.
* Add advanced search features to allow for more complicated searching.
* Update design to be responsive for horizontal viewing.
