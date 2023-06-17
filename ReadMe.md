# Online Ticket Booking System

### An online platform to book movie ticket across various cities and theatres

## Requirements

* A user can Log-in and select a City.
* After selecting a city, the user will be provided with a list of Theatres.
* A Theatre can be a single or multiple auditoriums.
* Each Auditorium will have a siting capacity.
* Each auditorium will have set of features.

```mermaid
   classDiagram
        class City {
            - String id
            - String name
            - List<Theatre>
        }
        
        class Theatre {
            - String id
            - String name
            - String address
            - List<Auditorium>
            - String company
        }
        
        class Auditorium {
            - String id
            - String name
            - List<Show>
            - List<Feature>
            - List<Seat>
        }
        
        class Feature {
            <<enum>>
            2D
            3D
            4D
            DOLBY
        }
        
        Theatre "1" --o  "M" Auditorium
        City "1" --o  "M" Theatre
        Feature "M" --o  "M" Auditorium
```

```mermaid
    erDiagram
    users {
        integer id PK
        varchar2 name 
        
    }
```