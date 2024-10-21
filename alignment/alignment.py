import requests
import os

# URLs of the repositories to compare
REPO_URLS = [
    "https://github.com/Matys53/REP_TP/blob/master/answer_associativity.txt?raw=true",
    "https://github.com/PaulineRoches/REP_popo_sos/blob/main/answer_associativity.txt?raw=true",
#"https://github.com/l55I1/REP/answer_associativity.txt?raw=true",
    "https://github.com/matth1446/rep_mh_vvk/blob/main/answer_associativity.txt?raw=true",
    "https://github.com/AntoineMarchalDombrat/REP_Antoine_Jean/blob/main/answer_associativity.txt?raw=true",
#"https://github.com/Humilokaki/TP2-REP-INSA-202425/blob/main/answer_associativity.txt?raw=true",
    "https://github.com/Repro-Arno-Jeremy/REP-TP2/blob/main/answer_associativity.txt?raw=true",
    "https://github.com/Kaeios/assoc-REP/blob/master/answer_associativity.txt?raw=true",
    "https://github.com/Dyskal/repro/blob/main/answer_associativity.txt?raw=true"
]

# Path to the local result
LOCAL_RESULT_FILE = "answer_associativity.txt"

# Precision handling
PRECISION = 2  # Number of decimal places to consider for comparison

def fetch_result(url):
    """
    Fetches the result from a given URL and returns it as a float.
    """
    try:
        response = requests.get(url)
        response.raise_for_status()  # Raise an error for bad status codes
        return float(response.text.strip())
    except requests.exceptions.RequestException as e:
        print(f"Failed to fetch result from {url}: {e}")
        return None

def compare_results(local_result, fetched_result):
    """
    Compares the local result with a fetched result. 
    If they differ beyond a small epsilon, the function returns False.
    """
    if local_result is None or fetched_result is None:
        return False
    
    return round(local_result, PRECISION) == round(fetched_result, PRECISION)

def get_local_result():
    """
    Reads the local result from the file and returns it as a float.
    """
    if not os.path.exists(LOCAL_RESULT_FILE):
        print(f"{LOCAL_RESULT_FILE} not found.")
        return None
    
    with open(LOCAL_RESULT_FILE, "r") as file:
        try:
            return float(file.read().strip())
        except ValueError:
            print(f"Invalid value in {LOCAL_RESULT_FILE}.")
            return None

def align_results():
    """
    Aligns the results between the local repository and the fetched results from other repositories.
    """
    local_result = get_local_result()
    if local_result is None:
        print("Local result is missing or invalid. Cannot proceed with alignment.")
        return

    print(f"Local result: {local_result:.2f}")

    discrepancies_found = False
    for url in REPO_URLS:
        fetched_result = fetch_result(url)
        if fetched_result is None:
            print(f"Skipping {url} due to error fetching result.")
            continue

        print(f"Fetched result from {url}: {fetched_result:.2f}")

        if not compare_results(local_result, fetched_result):
            print(f"Discrepancy detected with {url}: {local_result:.2f} != {fetched_result:.2f}")
            discrepancies_found = True
        else:
            print(f"Results aligned with {url}.")

    if discrepancies_found:
        print("Discrepancies detected, further investigation is needed to align results.")
    else:
        print("All results are aligned.")

if __name__ == "__main__":
    align_results()
