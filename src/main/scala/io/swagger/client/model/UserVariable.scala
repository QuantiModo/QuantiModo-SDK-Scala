package io.swagger.client.model

import org.joda.time.DateTime



case class UserVariable (
  /* ID of the parent variable if this variable has any parent */
  parent_id: Integer,
  /* client_id */
  client_id: String,
  /* ID of variable */
  variable_id: Integer,
  /* ID of unit to use for this variable */
  default_unit_id: Integer,
  /* Minimum reasonable value for this variable (uses default unit) */
  minimum_allowed_value: Float,
  /* Maximum reasonable value for this variable (uses default unit) */
  maximum_allowed_value: Float,
  /* Value for replacing null measurements */
  filling_value: Float,
  /* The Variable this Variable should be joined with. If the variable is joined with some other variable then it is not shown to user in the list of variables */
  join_with: Integer,
  /* How long it takes for a measurement in this variable to take effect */
  onset_delay: Integer,
  /* Estimated duration of time following the onset delay in which a stimulus produces a perceivable effect */
  duration_of_action: Integer,
  /* ID of variable category */
  variable_category_id: Integer,
  /* updated */
  updated: Integer,
  /* Is variable public */
  public: Integer,
  /* A value of 1 indicates that this variable is generally a cause in a causal relationship.  An example of a causeOnly variable would be a variable such as Cloud Cover which would generally not be influenced by the behaviour of the user */
  cause_only: Boolean,
  /* 0 -> No filling, 1 -> Use filling-value */
  filling_type: String,
  /* Number of measurements */
  number_of_measurements: Integer,
  /* Number of processed measurements */
  number_of_processed_measurements: Integer,
  /* Number of measurements at last analysis */
  measurements_at_last_analysis: Integer,
  /* ID of last Unit */
  last_unit_id: Integer,
  /* ID of last original Unit */
  last_original_unit_id: Integer,
  /* Last Value */
  last_value: Float,
  /* Last original value which is stored */
  last_original_value: Integer,
  /* ID of last source */
  last_source_id: Integer,
  /* Number of correlations for this variable */
  number_of_correlations: Integer,
  /* status */
  status: String,
  /* error_message */
  error_message: String,
  /* When this variable or its settings were last updated */
  last_successful_update_time: DateTime,
  /* Standard deviation */
  standard_deviation: Float,
  /* Variance */
  variance: Float,
  /* Minimum recorded daily value of this variable */
  minimum_recorded_daily_value: Float,
  /* Maximum recorded daily value of this variable */
  maximum_recorded_daily_value: Float,
  /* Mean */
  mean: Float,
  /* Median */
  median: Float,
  /* Most common Unit ID */
  most_common_unit_id: Integer,
  /* Most common value */
  most_common_value: Float,
  /* Number of unique daily values */
  number_of_unique_daily_values: Float,
  /* Number of changes */
  number_of_changes: Integer,
  /* Skewness */
  skewness: Float,
  /* Kurtosis */
  kurtosis: Float,
  /* Latitude */
  latitude: Float,
  /* Longitude */
  longitude: Float,
  /* Location */
  location: String,
  /* created_at */
  created_at: DateTime,
  /* updated_at */
  updated_at: DateTime,
  /* Outcome variables (those with `outcome` == 1) are variables for which a human would generally want to identify the influencing factors.  These include symptoms of illness, physique, mood, cognitive performance, etc.  Generally correlation calculations are only performed on outcome variables */
  outcome: Boolean,
  /* Comma-separated list of source names to limit variables to those sources */
  sources: String,
  /* Earliest source time */
  earliest_source_time: Integer,
  /* Latest source time */
  latest_source_time: Integer,
  /* Earliest measurement time */
  earliest_measurement_time: Integer,
  /* Latest measurement time */
  latest_measurement_time: Integer,
  /* Earliest filling time */
  earliest_filling_time: Integer,
  /* Latest filling time */
  latest_filling_time: Integer)
  
