import axios from "axios";

const API_URL = "http://localhost:8080/api/payments";

export const createPayment = async (amount) => {
    const response = await axios.post(API_URL, {
        amount: Number(amount)
    });

    return response.data;
};