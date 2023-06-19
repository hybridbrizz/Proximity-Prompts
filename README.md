# Fun Reminders

### You can customize reminders to appear based on:

- Coordiantes
- Geofences
- Regions
- Npcs
- Items
- Messages
- Times
- Days
- Dates

### Each reminder can appear in a list or in a sperate panel. Panels can be customized in different ways:

- Anchor
- (X, Y)
- Width
- Border
- Color
- Text Size
- Image
- Sound

Optionally a duration and cooldown can also be configured.

### Each character of reminder text can be set to a different color:

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

### Reminders can also be added using a JSON format

Unit, location, anchor, tsize, and sound are all configuration list index.

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
    
