import pandas as pd

# Sample data (can be loaded from a file or database)
data = {
    'Name': ['Alice', 'Bob', 'Charlie', 'David', 'Emily'],
    'Age': [25, 30, 35, 40, 45],
    'Salary': [50000, 60000, 70000, 80000, 90000]
}

# Create a DataFrame
df = pd.DataFrame(data)

# Basic reporting
print("Sample Data:")
print(df)

# Summary statistics
print("\nSummary Statistics:")
print(df.describe())

# Grouping and aggregation
print("\nAverage Salary by Age Group:")
print(df.groupby('Age')['Salary'].mean())

# Visualization (requires matplotlib or other plotting libraries)
"""import matplotlib.pyplot as plt

# Plotting
plt.bar(df['Name'], df['Salary'])
plt.xlabel('Name')
plt.ylabel('Salary')
plt.title('Salary Distribution')
plt.xticks(rotation=45)
plt.show()
"""