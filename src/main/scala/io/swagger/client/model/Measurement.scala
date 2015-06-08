package io.swagger.client.model




case class Measurement (
  /* ORIGINAL Name of the variable for which we are creating the measurement records */
  variable: String,
  /* Application or device used to record the measurement values */
  source: String,
  /* Timestamp for the measurement event in epoch time */
  timestamp: Long,
  /* Measurement value */
  value: Double,
  /* Unit of Measurement */
  unit: String,
  /* Optional note supplied with the measurement. Can be up to 255 characters in length. */
  note: String)
  
