# Conditional Pop-ups

Add little pop-ups that appear based on a combination of one or many coordinates, geofences, game regions, NPCs in range, idle NPCs in range, inventory items, message patterns, dates, and times.
Each pop-up can be stylized with text colors, icon, and sound.

Optionally a duration and cooldown can be set for each pop-up. For example to only show it for 5 seconds after the conditions are met or show and hide it at an interval.

By default pop-ups stay visible for as long as all the conditions are met.

This plugin runs off the default Runelite Panel packages so to configure window positions you can in plugin settings. Anchor, x, and y are those settings.

## Text Color Format

Append these formats before the letters you want to recolor.

- ^0 Configured color
- ^a Animated
- ^b Black
- ^c Cyan
- ^d Purple
- ^e Brown
- ^f Forset
- ^g Green
- ^h Light purple
- ^i Sherbet
- ^j Jam
- ^k Chocolate
- ^l Lime
- ^m Magenta
- ^n Light yellow
- ^o Orange
- ^p Pink
- ^q Black White Animated
- ^r Red
- ^u Blue
- ^w White
- ^y Yellow

## JSON Format

This plugin only supports 10 pop-ups at a time however additional pop-ups can be included on top of this with a JSON format.

```json
[
  {
    "force": false,
    "text": "Reminder",
    "color": "#FFFFFF",
    "duration": 5,
    "cd": 30,
    "unit": 0,
    "notify": false,
    "location": 1,
    "anchor": 0,
    "x": 10,
    "y": 20,
    "width": 150,
    "broder": true,
    "bg": "#000000",
    "tsize": 0,
    "sound": 1,
    "image": 2,
    "offset": 0,
    "noffset": false,
    "coords": [
      "(10,20)"
    ],
    "radius": 1,
    "geofences": [
      "(10,10,20,0)"
    ],
    "regions": [
      2
    ],
    "npcs": [
      3
    ],
    "idle_npcs": [
      5
    ],
    "items": [
      4
    ],
    "messages": [
      "cannon",
      "[0-9]{1,3}"
    ],
    "times": [
      "8:00pm",
      "9:00pm-11:00pm"
    ],
    "days": [
      "Sat"
    ],
    "dates": [
      "06/10",
      "09/15/22"
    ]
  }
]
```

Specifically unit, location, anchor, tsize, and sound are all the set list index.
