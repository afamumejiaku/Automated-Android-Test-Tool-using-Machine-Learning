import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from sklearn.model_selection import train_test_split
from sklearn.svm import SVC
from sklearn.metrics import classification_report, confusion_matrix


def clean_dataset(df):
    assert isinstance(df, pd.DataFrame), "df needs to be a pd.DataFrame"
    df.dropna(inplace=True)
    indices_to_keep = ~df.isin([np.nan, np.inf, -np.inf]).any(1)
    return df[indices_to_keep].astype(np.float64)


data = pd.ExcelFile("../datasets/datasets_final.xlsx")
test_data = pd.read_csv("../datasets/test1.csv")
data = data.parse("Sheet1")
data = data.fillna('0')
#test_data = test_data.parse("DataSet")
test_data = test_data.fillna('0')

X = data.drop(['Application', 'Activity_Type'], axis=1)
#X_test = test_data.drop(['Application', 'Activity_Type'], axis=1)
#target_names = ['Portal', 'Splash', 'To Do', 'Browser', 'Mail', 'Advertisement', 'Login']
X_test = test_data.drop(['Activity_Type'], axis=1)
y_test = test_data['Activity_Type']
#X = clean_dataset(X)
#y = data[['Application', 'Activity_Type']]
y = data['Activity_Type']
#X_train, X_test, y_train, y_test = train_test_split(X, y, test_size = 0.20)

X_train = X
y_train = y

svclassifier = SVC(kernel='linear')
svclassifier.fit(X_train, y_train)

y_pred = svclassifier.predict(X_test)

#print(y_test)
print(confusion_matrix(y_test,y_pred))
print(classification_report(y_test,y_pred))

