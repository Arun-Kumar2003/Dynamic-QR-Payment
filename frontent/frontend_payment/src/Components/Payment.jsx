import React, { useState } from "react";
import axios from "axios";
import { QRCodeCanvas } from "qrcode.react";
import "./Payment.css";

const Payment = () => {
  const [amount, setAmount] = useState("");
  const [payment, setPayment] = useState(null);
  const [loading, setLoading] = useState(false);

  const handleGenerateQR = async () => {
    if (!amount || Number(amount) <= 0) {
      alert("Please enter a valid amount");
      return;
    }

    try {
      setLoading(true);

      const response = await axios.post("http://localhost:8081/api/payments", {
        amount: Number(amount),
      });

      console.log("Backend Response:", response.data);

      setPayment(response.data);
    } catch (error) {
      console.error("Error:", error);

      alert("Failed to generate QR");
    } finally {
      setLoading(false);
    }
  };

  return (
    <>
      <div className="payment">
        <h1>Dynamic QR Payment</h1>

        <h2>Enter the Amount</h2>

        <input
          type="text"
          placeholder="Enter amount"
          value={amount}
          onChange={(e) => setAmount(e.target.value)}
        />

        <button onClick={handleGenerateQR}>
          {loading ? "GENERATING..." : "GENERATE QR"}
        </button>

        {/* QR CODE */}

        {payment && payment.qrData && (
          <div className="qr-section">
            <h2>Scan to Pay</h2>

            <QRCodeCanvas value={payment.qrData} size={250} />

            <h3>Amount: ₹{payment.amount}</h3>

            <p>Order ID: {payment.orderId}</p>
          </div>
        )}
      </div>
    </>
  );
};

export default Payment;
