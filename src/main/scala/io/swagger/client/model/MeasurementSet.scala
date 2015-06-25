package io.swagger.client.model

import io.swagger.client.model.ValueObject



case class MeasurementSet (
  /* Array of timestamps, values, and optional notes */
  measurements: List[ValueObject],
  /* ORIGINAL name of the variable for which we are creating the measurement records */
  name: String,
  /* Name of the application or device used to record the measurement values */
  source: String,
  /* Variable category name */
  category: String,
  /* Way to aggregate measurements over time. Options are \"MEAN\" or \"SUM\" */
  combinationOperation: String,
  /* Unit of measurement */
  unit: String)
  
