## API Documentation

This web service has several endpoints that allow you to interact with the Event data.

### Get Event by ID

- **URL**: `/events/{eventId}`
- **Method**: `GET`
- **URL Params**: `eventId=[string]`
- **Success Response**: Returns the event with the specified ID.
- **Error Response**: Returns an error message if the event with the specified ID does not exist.

### Get All Events

- **URL**: `/events`
- **Method**: `GET`
- **Success Response**: Returns a list of all events.

### Save a New Event

- **URL**: `/events`
- **Method**: `POST`
- **Data Params**: JSON object representing the event to be saved.
- **Success Response**: Returns the saved event.
- **Error Response**: Returns an error message if the event could not be saved.

### Update an Existing Event

- **URL**: `/events`
- **Method**: `PUT`
- **Data Params**: JSON object representing the event to be updated.
- **Success Response**: Returns the updated event.
- **Error Response**: Returns an error message if the event could not be updated.

### Delete an Event

- **URL**: `/events/{eventId}`
- **Method**: `DELETE`
- **URL Params**: `eventId=[string]`
- **Success Response**: Returns a success message if the event was deleted.
- **Error Response**: Returns an error message if the event with the specified ID does not exist or could not be deleted.