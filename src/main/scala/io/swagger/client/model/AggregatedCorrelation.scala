package io.swagger.client.model

import org.joda.time.DateTime



case class AggregatedCorrelation (
  /* id */
  id: Integer,
  /* correlation */
  correlation: Float,
  /* cause_id */
  cause_id: Integer,
  /* effect_id */
  effect_id: Integer,
  /* onset_delay */
  onset_delay: Integer,
  /* duration_of_action */
  duration_of_action: Integer,
  /* number_of_pairs */
  number_of_pairs: Integer,
  /* value_predicting_high_outcome */
  value_predicting_high_outcome: Float,
  /* value_predicting_low_outcome */
  value_predicting_low_outcome: Float,
  /* optimal_pearson_product */
  optimal_pearson_product: Float,
  /* vote */
  vote: Float,
  /* number_of_users */
  number_of_users: Integer,
  /* number_of_correlations */
  number_of_correlations: Integer,
  /* statistical_significance */
  statistical_significance: Float,
  /* cause_unit */
  cause_unit: String,
  /* cause_unit_id */
  cause_unit_id: Integer,
  /* cause_changes */
  cause_changes: Integer,
  /* effect_changes */
  effect_changes: Integer,
  /* aggregate_qm_score */
  aggregate_qm_score: Float,
  /* created_at */
  created_at: DateTime,
  /* updated_at */
  updated_at: DateTime,
  /* status */
  status: String,
  /* error_message */
  error_message: String,
  /* last_successful_update_time */
  last_successful_update_time: DateTime,
  /* reverse_pearson_correlation_coefficient */
  reverse_pearson_correlation_coefficient: Float,
  /* predictive_pearson_correlation_coefficient */
  predictive_pearson_correlation_coefficient: Float)
  
