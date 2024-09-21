<template>
  <div class="page-a">
    <h1>Page A</h1>
    <div class="random-numbers">
      <p v-for="(number, index) in randomNumbers" :key="index">
        Random Number {{ index + 1 }}: {{ number }}
      </p>
    </div>
    <button @click="goToPageB">Go to Page B</button>
    <button @click="goToPageC">Go to Page C</button>
    <button @click="saveAndRefresh">Save and Refresh</button>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'PageA',
  data() {
    return {
      randomNumbers: []
    }
  },
  mounted() {
    this.getRandomNumbers()
  },
  methods: {
    getRandomNumbers() {
      axios.get('/api/random')
          .then(response => {
            this.randomNumbers = response.data
          })
          .catch(error => {
            console.error('Error fetching random numbers:', error)
          })
    },
    goToPageB() {
      this.$router.push('/b')
    },
    goToPageC() {
      this.$router.push('/c')
    },
    saveAndRefresh() {
      axios.post('/api/save', this.randomNumbers)
          .then(() => {
            this.getRandomNumbers()
          })
          .catch(error => {
            console.error('Error saving random numbers:', error)
          })
    }
  }
}
</script>

<style scoped>
button {
  margin: 10px;
  padding: 10px;
  background-color: #4CAF50;
  color: white;
  border: none;
  cursor: pointer;
}
</style>
