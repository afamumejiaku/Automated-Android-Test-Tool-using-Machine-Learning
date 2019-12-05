import pandas as pd
#import tensorflow as tf

df = pd.read_csv("../datasets/dataset.csv")
print(df['clickable_top'])

clickable_top_feature = tf.feature_column.numeric_column("clickable_top")
clickable_middle_feature = tf.feature_column.numeric_column("clickable_middle")
clickable_bottom_feature = tf.feature_column.numeric_column("clickable_bottom")
vertical_swipeable_top_feature = tf.feature_column.numeric_column("vertical_swipeable_top")
vertical_swipeable_middle_feature = tf.feature_column.numeric_column("vertical_swipeable_middle")
vertical_swipeable_bottom_feature = tf.feature_column.numeric_column("vertical_swipeable_bottom")
horizontal_swipeable_top_feature = tf.feature_column.numeric_column("horizontal_swipeable_top")
horizontal_swipeable_middle_feature = tf.feature_column.numeric_column("horizontal_swipeable_middle")
horizontal_swipeable_bottom_feature = tf.feature_column.numeric_column("horizontal_swipeable_bottom")
text_field_top_feature = tf.feature_column.numeric_column("text_field_top")
text_field_middle_feature = tf.feature_column.numeric_column("text_field_middle")
text_field_bottom_feature = tf.feature_column.numeric_column("text_field_bottom")
general_elements_feature = tf.feature_column.numeric_column("general_elements")
long_clickable_feature = tf.feature_column.numeric_column("long_clickable")
navigation_drawer_feature = tf.feature_column.numeric_column("navigation_drawer")

feat_columns = [clickable_top_feature, clickable_middle_feature, clickable_bottom_feature,
                vertical_swipeable_top_feature, vertical_swipeable_middle_feature, vertical_swipeable_bottom_feature,
                horizontal_swipeable_top_feature, horizontal_swipeable_middle_feature,
                horizontal_swipeable_bottom_feature, text_field_top_feature, text_field_middle_feature,
                text_field_bottom_feature, general_elements_feature, long_clickable_feature, navigation_drawer_feature]

# X_data = df.drop("activity_type", axis=1)