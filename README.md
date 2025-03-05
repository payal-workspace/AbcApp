# Sports Catalog App

This Android app is built using **Multimodule Architecture**, **MVVM**, **Clean Architecture**, **Hilt**, and **Jetpack Compose** (with XML for UI). The app displays sports categories in a **ViewPager**, allows filtering with a **Search Bar**, and updates a **RecyclerView** below. Users can see **statistics** in a **bottom sheet** showing the top 3 most frequent characters in the list.

## Features

- **ViewPager**: Displays sports categories.
- **Search Bar**: Filters items in the RecyclerView based on the query.
- **RecyclerView**: Shows types of sports in the selected category.
- **Pinned Search Bar**: The search bar becomes pinned when scrolled above.
- **FAB**: Opens a bottom sheet displaying top 3 frequent characters in the list.

## Architecture

The app follows **Clean Architecture**:

- **Presentation Layer**: Activities/Fragments and ViewModels.
- **Domain Layer**: Use cases for business logic (e.g., fetching sports categories).
- **Data Layer**: Repositories to retrieve data from local sources.

## Libraries Used

- **Hilt** for Dependency Injection.
- **Jetpack ViewModel/StateFlow** for managing UI data.
- **RecyclerView** and **ViewPager** for displaying lists.
- **Coroutines** for background tasks.

## Screenshots
<div style="display: flex; justify-content: space-around;">
<img src="Screenshots/sports_main_page.png" alt="Sports Main Page" width="150"/>
<img src="Screenshots/filter_screen.png" alt="Filter Screen" width="150"/>
<img src="Screenshots/search_bar_pinned_on_top_page.png" alt="Pinned Search Bar" width="150"/>
<img src="Screenshots/top_categories_page.png" alt="Top Categories" width="150"/>
<img src="Screenshots/top_categories_with_filter_page.png" alt="Top Categories With Filtered Data" width="150"/>
</div>


