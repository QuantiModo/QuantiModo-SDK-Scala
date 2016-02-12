package io.swagger.client.model




case class CommonVariableRelationship (
  /* id */
  id: Integer,
  /* Our confidence that a consistent predictive relationship exists based on the amount of evidence, reproducibility, and other factors */
  confidence_level: String,
  /* A quantitative representation of our confidence that a consistent predictive relationship exists based on the amount of evidence, reproducibility, and other factors */
  confidence_score: Float,
  /* Direction is positive if higher predictor values generally precede higher outcome values. Direction is negative if higher predictor values generally precede lower outcome values. */
  direction: String,
  /* duration_of_action */
  duration_of_action: Integer,
  /* error_message */
  error_message: String,
  /* User estimated (or default number of seconds) after cause measurement before a perceivable effect is observed */
  onset_delay: Integer,
  /* Variable ID for the outcome variable */
  outcome_variable_id: Integer,
  /* Variable ID for the predictor variable */
  predictor_variable_id: Integer,
  /* ID for default unit of the predictor variable */
  predictor_unit_id: Integer,
  /* A value representative of the relevance of this predictor relative to other predictors of this outcome.  Usually used for relevancy sorting. */
  sinn_rank: Float,
  /* A value represented to the size of the effect which the predictor appears to have on the outcome. */
  strength_score: Float,
  /* Can be weak, medium, or strong based on the size of the effect which the predictor appears to have on the outcome relative to other variable relationship strength scores. */
  strength_level: String,
  /* Number of users who feel that there is a plausible causal relationship between the predictor and outcome variables. */
  up_votes: Integer,
  /* Number of users who do not feel that there is a plausible causal relationship between the predictor and outcome variables. */
  down_votes: Integer,
  /* Value for the predictor variable (in it's default unit) which typically precedes an above average outcome value */
  value_predicting_high_outcome: Float,
  /* Value for the predictor variable (in it's default unit) which typically precedes a below average outcome value */
  value_predicting_low_outcome: Float,
  /* Number of users whose data was aggregated to obtain this relationship */
  number_of_users: Integer,
  /* Source of data for this common variable relationship */
  data_source: String)
  
