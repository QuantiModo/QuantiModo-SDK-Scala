package io.swagger.client.model




case class MeasurementValue (
  /* When the measurement event occurred . Use ISO 8601 datetime format */
  start_time: String,
  /* Value for the measurement */
  value: Float,
  /* An optional note the user may include with their measurement */
  note: String)
  
