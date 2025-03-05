package com.example.data.dataSource

import com.example.data.R
import com.example.data.model.SportsCategoryData
import com.example.data.model.SportsCategoryEntity
import com.example.data.model.SportsCategoryLists

sealed class SportsCategory(val name: String, val iconResId: Int) {
    object Adventure : SportsCategory("Adventure Sports", R.drawable.ic_rock_climbing)
    object Water : SportsCategory("Water Sports", R.drawable.ic_rafting)
    object Team : SportsCategory("Team Sports", R.drawable.ic_basketball)
    object Individual : SportsCategory("Individual Sports", R.drawable.ic_golf)
    object Winter : SportsCategory("Winter Sports", R.drawable.ic_winter_sport)
    object Racing : SportsCategory("Racing Sports", R.drawable.ic_racing_sport)
}

class SportsTable : SportsDataSource {
    private val sportsListsData = SportsCategoryEntity(
        data = listOf(
            createCategory(
                SportsCategory.Adventure,
                listOf(
                    SportsCategoryLists(
                        "Mountaineering",
                        "Scaling heights in challenging terrain.",
                        R.drawable.ic_mountaineering
                    ),
                    SportsCategoryLists("Trekking", "Long-distance hikes.", R.drawable.ic_trekking),
                    SportsCategoryLists(
                        "Rock Climbing",
                        "Climbing steep rocks.",
                        R.drawable.ic_rock_climbing
                    ),
                    SportsCategoryLists(
                        "Hot Air Ballooning",
                        "Soaring through the sky.",
                        R.drawable.ic_hot_air_ballooning
                    ),
                    SportsCategoryLists(
                        "Bungee Jumping",
                        "Leap into the void & defy gravity.",
                        R.drawable.ic_bungee_jumping
                    ),
                    SportsCategoryLists(
                        "Paragliding",
                        "Glide with the wind as your guide.",
                        R.drawable.ic_paragliding
                    ),
                    SportsCategoryLists(
                        "Cave Exploration",
                        "Venture deep into Earth's hidden mysteries.",
                        R.drawable.ic_cave_explorer
                    ),
                    SportsCategoryLists(
                        "Zip Lining",
                        "Embracing with the thrilling heights.",
                        R.drawable.ic_zip_lining
                    ),
                    SportsCategoryLists(
                        "Snowboarding",
                        "Carve the snow with speed and style.",
                        R.drawable.snowboarding
                    ),
                    SportsCategoryLists(
                        "Mountain Biking",
                        "Conquer rugged trails with fueled rides.",
                        R.drawable.ic_mountain_biking
                    ),
                    SportsCategoryLists(
                        "Kite Surfing",
                        "Harness the wind for a dance atop the waves.",
                        R.drawable.ic_kite_surfing
                    )
                )
            ),
            createCategory(
                SportsCategory.Water,
                listOf(
                    SportsCategoryLists(
                        "Diving",
                        "Jumping into water from a height.",
                        R.drawable.ic_scuba_diving
                    ),
                    SportsCategoryLists(
                        "Swimming",
                        "A popular sport for fitness & recreation.",
                        R.drawable.ic_swimming
                    ),
                    SportsCategoryLists(
                        "Surfing",
                        "Riding waves on a surfboard.",
                        R.drawable.ic_surfing
                    ),
                    SportsCategoryLists(
                        "Scuba Diving",
                        "Dive deep to discover underwater ecosystems.",
                        R.drawable.ic_scuba_diving
                    ),
                    SportsCategoryLists(
                        "Jet Skiing",
                        "Racing across the water's surface.",
                        R.drawable.ic_jet_skiing
                    ),
                    SportsCategoryLists(
                        "Kayaking",
                        "Paddle your way through serene waters.",
                        R.drawable.ic_kayaking
                    ),
                    SportsCategoryLists(
                        "Rafting",
                        "Navigate wild rivers with a team of adventurers.",
                        R.drawable.ic_rafting
                    ),
                    SportsCategoryLists(
                        "Yachting",
                        "Glide gracefully across the water in luxury.",
                        R.drawable.ic_yachting
                    ),
                    SportsCategoryLists(
                        "Fishing",
                        "Cast your line and await nature’s quiet rewards",
                        R.drawable.ic_fishing
                    ),
                    SportsCategoryLists(
                        "Water Polo",
                        "A fast-paced sport played in the pool.",
                        R.drawable.ic_water_polo
                    ),
                    SportsCategoryLists(
                        "Sailing",
                        "Harness the power of wind gliding with water",
                        R.drawable.ic_sailing
                    ),
                )
            ),
            createCategory(
                SportsCategory.Racing,
                listOf(
                    SportsCategoryLists(
                        "Speed Climbing", "Race against time to scale towering heights.",
                        R.drawable.ic_speed_climbing
                    ),
                    SportsCategoryLists(
                        "Paralympic Swimming", "Competitive swimming with inclusive adaptations.",
                        R.drawable.ic_paralympic_swimming
                    ),
                    SportsCategoryLists(
                        "Marathon Swimming", "Long-distance swimming in open waters.",
                        R.drawable.ic_marathon_racing
                    ),
                    SportsCategoryLists(
                        "Sandboarding", "Ride the dunes with style on a sandboard.",
                        R.drawable.ic_sandboarding
                    ),
                    SportsCategoryLists(
                        "Track Cycling", "Racing on velodromes with high-speed bicycles.",
                        R.drawable.ic_track_cycling
                    ),
                    SportsCategoryLists(
                        "Skiing", "Glide down slopes, mastering speed and technique.",
                        R.drawable.ic_skiing
                    ),
                    SportsCategoryLists(
                        "Rafting",
                        "Navigate wild rivers with a team of adventurers.",
                        R.drawable.ic_rafting
                    ),
                    SportsCategoryLists(
                        "Skating", "Speed across ice, mastering balance and agility.",
                        R.drawable.ic_skating
                    ),
                    SportsCategoryLists(
                        "Camel Racing", "A unique race through the desert with camels.",
                        R.drawable.ic_camel_racing
                    ),
                    SportsCategoryLists(
                        "Drone Racing", "Fly drones at top speed in high-stakes races.",
                        R.drawable.ic_drone_racing
                    ),
                    SportsCategoryLists(
                        "Motorcycle Racing", "Speed on two wheels in thrilling track races.",
                        R.drawable.ic_motorcycle_racing
                    ),
                    SportsCategoryLists(
                        "Slot Car Racing", "Tiny cars, high speeds, and precise control.",
                        R.drawable.ic_slot_car_racing
                    ),
                    SportsCategoryLists(
                        "Rowing", "A team sport requiring strength, rhythm, and coordination.",
                        R.drawable.ic_rowing
                    ),
                    SportsCategoryLists(
                        "Yacht Racing", "Navigate the seas in a race against time and wind.",
                        R.drawable.ic_yatch_racing
                    ),

                    )
            ),
            createCategory(
                SportsCategory.Team,
                listOf(
                    SportsCategoryLists(
                        "Basketball", "A fast-paced team sport played on a court.",
                        R.drawable.ic_basketball
                    ),
                    SportsCategoryLists(
                        "Volleyball", "A game involving two teams and a net.",
                        R.drawable.ic_volleyball
                    ),
                    SportsCategoryLists(
                        "Cricket", "A bat-and-ball game popular worldwide.",
                        R.drawable.ic_cricket
                    ),
                    SportsCategoryLists(
                        "Football", "Played with a ball on field or ice.",
                        R.drawable.ic_football
                    ),
                    SportsCategoryLists(
                        "Baseball", "A traditional game of bat & ball with strategic plays.",
                        R.drawable.ic_baseball
                    ),
                    SportsCategoryLists(
                        "Badminton", "A high-speed game involving a shuttlecock and rackets.",
                        R.drawable.ic_badminton
                    ),
                    SportsCategoryLists(
                        "Snow Volleyball", "A winter twist on classic volleyball.",
                        R.drawable.ic_snow_volleyball
                    ),
                    SportsCategoryLists(
                        "Tug of War", "A strength-based team game requiring coordination.",
                        R.drawable.ic_tug_of_war
                    ),
                    SportsCategoryLists(
                        "Handball", "A fast-paced ball game, played with hands and strategy.",
                        R.drawable.ic_handball
                    ),
                )
            ),
            createCategory(
                SportsCategory.Individual,
                listOf(
                    SportsCategoryLists(
                        "Chess" , "A strategic game of minds.",
                        R.drawable.ic_chess
                    ),
                    SportsCategoryLists(
                        "Darts" , "A precision-based individual game.",
                        R.drawable.ic_darts
                    ),
                    SportsCategoryLists(
                        "Golf" , "Played on expansive green courses.",
                        R.drawable.ic_golf
                    ),
                    SportsCategoryLists(
                        "Tennis" , "A racket-based individual or duo sport.",
                        R.drawable.ic_tennis
                    ),
                    SportsCategoryLists(
                        "Taekwondo" , "A martial art emphasizing self-discipline.",
                        R.drawable.ic_taekwondo
                    ),
                    SportsCategoryLists(
                        "Snooker" ,"A cue sport focusing on precision and strategy.",
                        R.drawable.ic_snooker
                    ),
                    SportsCategoryLists(
                        "Fishing",
                        "Cast your line and await nature’s quiet rewards",
                        R.drawable.ic_fishing
                    ),
                    SportsCategoryLists(
                        "Bodybuilding" , "Strength & muscle development through disciplined training.",
                        R.drawable.ic_bodybuilding
                    ),
                    SportsCategoryLists(
                        "Motorcycling" ,"Speed and skill on two wheels.",
                        R.drawable.ic_motorcycling
                    ),
                    SportsCategoryLists(
                        "Weightlifting" , "A sport of strength where lifting is the main challenge.",
                        R.drawable.ic_weightlifting
                    ),
                    SportsCategoryLists(
                        "Archery" , "Aim for the target with precision and focus.",
                        R.drawable.ic_archery
                    ),
                )
            ),
            createCategory(
                SportsCategory.Winter,
                listOf(
                    SportsCategoryLists(
                        "Ice Skating" , "Grace and speed on ice, from figure skating to racing.",
                        R.drawable.ic_ice_skating
                    ),
                    SportsCategoryLists(
                        "Skiing" ,"Glide down snowy slopes with style and speed.",
                        R.drawable.ic_skiing
                    ),
                    SportsCategoryLists(
                        "Snowbiking" , "Ride your bike through the snowy terrain.",
                        R.drawable.ic_snow_biking
                    ),
                    SportsCategoryLists(
                        "Snow Golf" , "A unique take on golf, played in snowy landscapes.",
                        R.drawable.ic_snow_golf
                    ),
                    SportsCategoryLists(
                        "Snow Polo" , "Polo played on snow-covered fields.",
                        R.drawable.ic_snow_polo
                    ),
                    SportsCategoryLists(
                        "Ice Fishing" , "Patience and skill as you fish through the ice.",
                        R.drawable.ic_ice_fishing
                    ),
                    SportsCategoryLists(
                        "Monoskiing" , "Skiing on a single ski for a unique challenge.",
                        R.drawable.ic_mono_skiing
                    ),
                    SportsCategoryLists(
                        "Speed Skiing" , "Skiing with a focus on maximum speed.",
                        R.drawable.ic_speed_skiing
                    ),
                    SportsCategoryLists(
                        "Sneak Boat Hunting" , "A quiet, stealthy approach to hunting on water.",
                        R.drawable.ic_sneak_boat_hunting
                    ),
                    SportsCategoryLists(
                        "Ice Yachting" , "Sailing across frozen lakes with ice yachts.",
                        R.drawable.ic_ice_yachting
                    ),
                    SportsCategoryLists(
                        "Winter Swimming" , "Brave the cold for a refreshing dip in icy waters.",
                        R.drawable.ic_winter_swimming
                    ),
                )
            )
        )
    )


    private fun createCategory(
        category: SportsCategory,
        items: List<SportsCategoryLists>
    ): SportsCategoryData {
        return SportsCategoryData(
            sportsCategoryTitle = category.name,
            sportsCategoryImageUrl = category.iconResId,
            sportsCategoryItem = items.map { item ->
                SportsCategoryLists(
                    sportsImageUrl = item.sportsImageUrl,
                    sportsTitle = item.sportsTitle,
                    sportsDescription = item.sportsDescription
                )
            }
        )
    }

    override suspend fun fetchSportsCategories(): SportsCategoryEntity {
        return sportsListsData
    }


}
