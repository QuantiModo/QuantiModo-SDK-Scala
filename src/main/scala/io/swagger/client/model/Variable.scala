package io.swagger.client.model

import org.joda.time.DateTime



case class Variable (
  /* id */
  id: Integer,
  /* client_id */
  client_id: String,
  /* ID of the parent variable if this variable has any parent */
  parent_id: Integer,
  /* User-defined variable display name */
  name: String,
  /* Variable category ID */
  variable_category_id: Integer,
  /* ID of the default unit of measurement to use for this variable */
  default_unit_id: Integer,
  /* How to combine values of this variable (for instance, to see a summary of the values over a month) SUM or MEAN */
  combination_operation: String,
  /* Value for replacing null measurements */
  filling_value: Float,
  /* Maximum reasonable value for this variable (uses default unit) */
  maximum_allowed_value: Float,
  /* Minimum reasonable value for this variable (uses default unit) */
  minimum_allowed_value: Float,
  /* How long it takes for a measurement in this variable to take effect */
  onset_delay: Integer,
  /* How long the effect of a measurement in this variable lasts */
  duration_of_action: Integer,
  /* Is variable public */
  public: Integer,
  /* A value of 1 indicates that this variable is generally a cause in a causal relationship.  An example of a causeOnly variable would be a variable such as Cloud Cover which would generally not be influenced by the behaviour of the user */
  cause_only: Boolean,
  /* Most common value */
  most_common_value: Float,
  /* Most common Unit */
  most_common_unit_id: Integer,
  /* Standard Deviation */
  standard_deviation: Float,
  /* Variance */
  variance: Float,
  /* Mean */
  mean: Float,
  /* Median */
  median: Float,
  /* Number of measurements */
  number_of_measurements: Float,
  /* Number of unique values */
  number_of_unique_values: Float,
  /* Skewness */
  skewness: Float,
  /* Kurtosis */
  kurtosis: Float,
  /* status */
  status: String,
  /* error_message */
  error_message: String,
  /* When this variable or its settings were last updated */
  last_successful_update_time: DateTime,
  /* When the record was first created. Use ISO 8601 datetime format */
  created_at: DateTime,
  /* When the record in the database was last updated. Use ISO 8601 datetime format */
  updated_at: DateTime,
  /* Product URL */
  product_url: String,
  /* Image URL */
  image_url: String,
  /* Price */
  price: Float,
  /* Number of variables */
  number_of_user_variables: Integer,
  /* Outcome variables (those with `outcome` == 1) are variables for which a human would generally want to identify the influencing factors.  These include symptoms of illness, physique, mood, cognitive performance, etc.  Generally correlation calculations are only performed on outcome variables. */
  outcome: Boolean,
  /* Minimum recorded value of this variable */
  minimum_recorded_value: Float,
  /* Maximum recorded value of this variable */
  maximum_recorded_value: Float)
  
