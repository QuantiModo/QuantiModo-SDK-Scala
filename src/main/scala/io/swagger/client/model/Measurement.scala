package io.swagger.client.model

import org.joda.time.DateTime



case class Measurement (
  /* id */
  id: Integer,
  /* ID of user that owns this measurement */
  user_id: Integer,
  /* client_id */
  client_id: String,
  /* Connector ID */
  connector_id: Integer,
  /* ID of the variable for which we are creating the measurement records */
  variable_id: Integer,
  /* Application or device used to record the measurement values */
  source_id: Integer,
  /* Start Time for the measurement event in ISO 8601 */
  start_time: Integer,
  /* Converted measurement value in requested unit */
  value: Float,
  /* Unit ID of measurement as requested in GET request */
  unit_id: Integer,
  /* Original value */
  original_value: Float,
  /* Unit ID of measurement as originally submitted */
  original_unit_id: Integer,
  /* duration of measurement in seconds */
  duration: Integer,
  /* Note of measurement */
  note: String,
  /* latitude */
  latitude: Float,
  /* longitude */
  longitude: Float,
  /* location */
  location: String,
  /* created_at */
  created_at: DateTime,
  /* updated_at */
  updated_at: DateTime,
  /* error */
  error: String)
  
