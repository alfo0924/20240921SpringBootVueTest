<template>
  <div class="page-c">
    <h1>Page C</h1>
    <button @click="goToPageA">Go to Page A</button>
    <button @click="goToPageB">Go to Page B</button>
    <button @click="fetchAllNumbers">Fetch All Numbers</button>
    <div v-if="allNumbers.length > 0">
      <h2>All Saved Numbers:</h2>
      <ul>
        <li v-for="number in allNumbers" :key="number.id">
          ID: {{ number.id }}, Value: {{ number.value }}
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'PageC',
  data() {
    return {
      allNumbers: []
    }
  },
  methods: {
    goToPageA() {
      this.$router.push('/a')
    },
    goToPageB() {
      this.$router.push('/b')
    },
    fetchAllNumbers() {
      axios.get('/api/all')
          .then(response => {
            this.allNumbers = response.data
          })
          .catch(error => {
            console.error('Error fetching all numbers:', error)
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
ul {
  list-style-type: none;
  padding: 0;
}
li {
  margin: 5px 0;
}
</style>
