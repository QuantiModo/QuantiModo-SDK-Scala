package io.swagger.client.model

import org.joda.time.DateTime



case class VariableCategory (
  /* id */
  id: Integer,
  /* Name of the category */
  name: String,
  /* Value for replacing null measurements */
  filling_value: Float,
  /* Maximum recorded value of this category */
  maximum_allowed_value: Float,
  /* Minimum recorded value of this category */
  minimum_allowed_value: Float,
  /* How long the effect of a measurement in this variable lasts */
  duration_of_action: Integer,
  /* How long it takes for a measurement in this variable to take effect */
  onset_delay: Integer,
  /* How to combine values of this variable (for instance, to see a summary of the values over a month) 0 for sum OR 1 for mean */
  combination_operation: String,
  /* updated */
  updated: Integer,
  /* A value of 1 indicates that this category is generally a cause in a causal relationship.  An example of a causeOnly category would be a category such as Work which would generally not be influenced by the behaviour of the user */
  cause_only: Boolean,
  /* Is category public */
  public: Integer,
  /* outcome */
  outcome: Boolean,
  /* created_at */
  created_at: DateTime,
  /* updated_at */
  updated_at: DateTime,
  /* Image URL */
  image_url: String,
  /* ID of the default unit for the category */
  default_unit_id: Integer)
  
