<template>
    <div>
        <TicketDetail v-if="responseData" :result="responseData"/>
    </div>
</template>

<script setup lang="ts">
const responseData = ref()
const route = useRoute()
const id = route.params.id

onMounted(async () => {
    try {
        const response = await fetch(`/api/tickets/${id}`)
        if (!response.ok) {
            throw new Error('No available data');
        }
        const data = await response.json();
        
        responseData.value = data;
    } catch (error: any) {
        console.error('Error fetching data:', error.message);
    }
});
</script>

<style lang="scss"></style>