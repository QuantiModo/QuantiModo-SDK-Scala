package io.swagger.client.model




case class Measurement (
  /* ORIGINAL Name of the variable for which we are creating the measurement records */
  variable: String,
  /* Application or device used to record the measurement values */
  source: String,
  /* Timestamp for the measurement event in epoch time */
  timestamp: Long,
  /* Start Time for the measurement event in ISO 8601 */
  startTime: String,
  /* Start Time for the measurement event in ISO 8601 */
  humanTime: HumanTime,
  /* Converted measurement value in requested unit */
  value: Double,
  /* Unit of measurement as requested in GET request */
  unit: String,
  /* Original value */
  originalValue: Integer,
  /* Measurement value in the unit as orignally submitted */
  storedValue: Double,
  /* Unit of measurement as originally submitted */
  storedAbbreviatedUnitName: String,
  /* Original Unit of measurement as originally submitted */
  originalAbbreviatedUnitName: String,
  /* Unit of measurement as originally submitted */
  abbreviatedUnitName: String,
  /* Note of measurement */
  note: String)
  
