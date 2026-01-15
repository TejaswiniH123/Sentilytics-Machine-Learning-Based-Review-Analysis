const API = "http://localhost:8081/api/sentiment";

async function analyzeSentiment() {
    const review = document.getElementById("reviewInput").value.trim();
    const loading = document.getElementById("loadingText");
    const error = document.getElementById("errorText");

    error.classList.add("hidden");

    if (!review) {
        error.textContent = "Please enter a review.";
        error.classList.remove("hidden");
        return;
    }

    loading.classList.remove("hidden");

    try {
        const response = await fetch(`${API}/predict`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ review })
        });

        if (!response.ok) {
            throw new Error("Server error");
        }

        const data = await response.json();

        document.getElementById("result").classList.remove("hidden");
        document.getElementById("sentimentBadge").textContent = data.sentiment;
        document.getElementById("confidenceText").textContent =
            `Confidence: ${Math.round(data.confidence * 100)}%`;
        document.getElementById("confidenceFill").style.width =
            `${Math.round(data.confidence * 100)}%`;

        loadStats();
        loadHistory();

    } catch (err) {
        error.textContent = "Unable to analyze sentiment. Please try again.";
        error.classList.remove("hidden");
    } finally {
        loading.classList.add("hidden");
    }
}


async function loadStats() {
    const res = await fetch(`${API}/stats`);
    const data = await res.json();

    document.getElementById("totalCount").textContent = data.total;
    document.getElementById("positiveCount").textContent = data.positive;
    document.getElementById("negativeCount").textContent = data.negative;
}

async function loadHistory() {
    const res = await fetch(`${API}/history`);
    const data = await res.json();

    const table = document.getElementById("historyTable");
    table.innerHTML = "";

    data.reverse().forEach(item => {
        const row = `
            <tr>
                <td>${item.review}</td>
                <td>${item.sentiment}</td>
                <td>${Math.round(item.confidence * 100)}%</td>
            </tr>
        `;
        table.innerHTML += row;
    });
}

loadStats();
loadHistory();
