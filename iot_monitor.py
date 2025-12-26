import time
import random

# Simulated IoT Temperature Monitoring System
def read_sensor_data():
    # Simulating a DHT11 Temperature Sensor
    temperature = random.uniform(20.0, 30.0)
    humidity = random.uniform(40.0, 60.0)
    return round(temperature, 2), round(humidity, 2)

def upload_to_cloud(temp, hum):
    print(f"[CLOUD] Uploading Data... Temp: {temp}°C, Humidity: {hum}%")

print("--- IoT Smart Home System Started ---")
try:
    for i in range(5):
        t, h = read_sensor_data()
        upload_to_cloud(t, h)
        time.sleep(1) # Simulating data interval
except KeyboardInterrupt:
    print("System Stopped.")