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
  unit: String)
  
