package io.swagger.client.model




case class ValueObject (
  /* Timestamp for the measurement event in epoch time (unixtime) */
  timestamp: Long,
  /* Measurement value */
  value: Double,
  /* Optional note to include with the measurement */
  note: String)
  
