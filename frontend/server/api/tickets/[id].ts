
export default defineEventHandler(async (event) => {
    const id = getRouterParam(event, 'id')
    try {
        const response = await fetch(`http://localhost:8080/ticket/${id}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        });
    
        if (!response.ok) {
            throw new Error('no available data');
        }

        return response
    } catch (error) {
        console.error('Error during fetch:', error);
    }

})