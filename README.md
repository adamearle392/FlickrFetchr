# FlickrFetchr
Android app which fetches images from Flickr api

## Architecture

- Clean Code - separated data, domain and presentation layers, included for maintainability and flexibility of implementation details, e.g. domain logic can remain the same if the api networking library has changed
- MVVM - Model/View/ViewModel - One of the most popular and well supported Android architecture styles that restricts the view from containing too much logic by delegating functions to the ViewModel and domain Models
- Dependency Injection - refrains from multiple dependency instances being created, e.g. a PhotoRepository will only be created once and shared around ViewModels


## Third party libraries

- kapt - kotlin annotation processing tool - used in kotlin projects to replace java's annotation processor when including dependencies
- Dagger/Hilt - Android's recommended dependency injection framework
- Jetpack Compose - New Kotlin based UI framework for Android for ease of UI development
- RetroFit/Moshi - for fetching data from an api, converting to Json then converting to locally used kotlin objects
- Coil - performant and lightweight image loading library based around kotlin
