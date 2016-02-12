package io.swagger.client.model

import org.joda.time.DateTime



case class Measurement (
  /* id */
  id: Integer,
  /* ID of user that owns this measurement */
  user_id: Integer,
  /* client_id */
  client_id: String,
  /* The id for the connector data source from which the measurement was obtained */
  connector_id: Integer,
  /* ID of the variable for which we are creating the measurement records */
  variable_id: Integer,
  /* Application or device used to record the measurement values */
  source_id: Integer,
  /* Start Time for the measurement event. Use ISO 8601 */
  start_time: String,
  /* The value of the measurement after conversion to the default unit for that variable */
  value: Float,
  /* The default unit for the variable */
  unit_id: Integer,
  /* Value of measurement as originally posted (before conversion to default unit) */
  original_value: Float,
  /* Unit ID of measurement as originally submitted */
  original_unit_id: Integer,
  /* Duration of the event being measurement in seconds */
  duration: Integer,
  /* An optional note the user may include with their measurement */
  note: String,
  /* Latitude at which the measurement was taken */
  latitude: Float,
  /* Longitude at which the measurement was taken */
  longitude: Float,
  /* location */
  location: String,
  /* When the record was first created. Use ISO 8601 datetime format */
  created_at: DateTime,
  /* When the record in the database was last updated. Use ISO 8601 datetime format */
  updated_at: DateTime,
  /* error */
  error: String)
  
