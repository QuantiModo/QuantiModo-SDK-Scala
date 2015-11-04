package io.swagger.client.model

import org.joda.time.DateTime



case class Variable (
  /* id */
  id: Integer,
  /* client_id */
  client_id: String,
  /* parent_id */
  parent_id: Integer,
  /* Name of the variable */
  name: String,
  /* Category of the variable */
  variable_category_id: Integer,
  /* ID of the default unit of measurement to use for this variable */
  default_unit_id: Integer,
  /* How to combine values of this variable (for instance, to see a summary of the values over a month) 0 for sum OR 1 for mean */
  combination_operation: String,
  /* filling_value */
  filling_value: Float,
  /* maximum_allowed_value */
  maximum_allowed_value: Float,
  /* minimum_allowed_value */
  minimum_allowed_value: Float,
  /* onset_delay */
  onset_delay: Integer,
  /* duration_of_action */
  duration_of_action: Integer,
  /* public */
  public: Integer,
  /* cause_only */
  cause_only: Boolean,
  /* most_common_value */
  most_common_value: Float,
  /* most_common_unit_id */
  most_common_unit_id: Integer,
  /* standard_deviation */
  standard_deviation: Float,
  /* variance */
  variance: Float,
  /* mean */
  mean: Float,
  /* median */
  median: Float,
  /* number_of_measurements */
  number_of_measurements: Float,
  /* number_of_unique_values */
  number_of_unique_values: Float,
  /* skewness */
  skewness: Float,
  /* kurtosis */
  kurtosis: Float,
  /* status */
  status: String,
  /* error_message */
  error_message: String,
  /* last_successful_update_time */
  last_successful_update_time: DateTime,
  /* created_at */
  created_at: DateTime,
  /* updated_at */
  updated_at: DateTime,
  /* product_url */
  product_url: String,
  /* image_url */
  image_url: String,
  /* price */
  price: Float,
  /* number_of_user_variables */
  number_of_user_variables: Integer,
  /* outcome */
  outcome: Boolean,
  /* minimum_recorded_value */
  minimum_recorded_value: Float,
  /* maximum_recorded_value */
  maximum_recorded_value: Float)
  
