package io.swagger.client.model




case class UserVariableRelationship (
  /* id */
  id: Integer,
  /* Our confidence that a consistent predictive relationship exists based on the amount of evidence, reproducibility, and other factors */
  confidence_level: String,
  /* A quantitative representation of our confidence that a consistent predictive relationship exists based on the amount of evidence, reproducibility, and other factors */
  confidence_score: Float,
  /* Direction is positive if higher predictor values generally precede higher outcome values. Direction is negative if higher predictor values generally precede lower outcome values. */
  direction: String,
  /* Number of seconds over which the predictor variable event is expected to produce a perceivable effect following the onset delay */
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
  /* Can be weak, medium, or strong based on the size of the effect which the predictor appears to have on the outcome relative to other variable relationship strength scores. */
  strength_level: String,
  /* A value represented to the size of the effect which the predictor appears to have on the outcome. */
  strength_score: Float,
  /* user_id */
  user_id: Integer,
  /* vote */
  vote: String,
  /* Value for the predictor variable (in it's default unit) which typically precedes an above average outcome value */
  value_predicting_high_outcome: Float,
  /* Value for the predictor variable (in it's default unit) which typically precedes a below average outcome value */
  value_predicting_low_outcome: Float)
  
