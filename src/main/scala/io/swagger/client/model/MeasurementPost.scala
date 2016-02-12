package io.swagger.client.model




case class MeasurementPost (
  /* ID of the variable for the measurement as obtained from the GET variables endpoint */
  variable_id: Integer,
  /* Source ID of the app or device as obtained from the GET sources endpoint */
  source_id: Integer,
  /* Unit id for the measurement value as obtained from the GET units endpoint */
  unit_id: Integer,
  /* measurements */
  measurements: List[MeasurementValue])
  
